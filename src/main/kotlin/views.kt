import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Views {

    private  var entryModel : EntryModel? = null
    private var calendarUtils: CalendarUtils? = null

    init {

        entryModel = EntryModel()
        calendarUtils = CalendarUtils()
    }

   private var selectedOption: Int = 0

   private var title: String = "SCHEDULER".trim()

  private  var greetings = "Hello , what do you want to do today".trim()

  private  var options = """
        1. make an entry
        2. see today's schedule
        3. see week's schedule
        4. see a month's schedule
    """.trimMargin()



   private var prompt = "Enter option: (1/2/3/4) ".trim()


    fun showWholePrompt(){
        println("""
            $title
            $greetings
            $options
            $prompt
        """.trimMargin())

        selectedOption = readLine()!!.toInt()
        checkOptionValidity(selectedOption)
    }

    //check to see if the input from the user is correct
    fun checkOptionValidity( selected : Int){

        if( selected in 1..4){

            //call check options
            checkOptionSelected(selected)
        }else{
            println("Your number: $selected is not a valid selection")
            showWholePrompt()
        }

    }


    fun checkOptionSelected( selected: Int){
        when( selected){
            1 -> makeEntry()//call make entry function
            2 -> showTodaysSchedule()//call show today's schedule
            3 -> showWeeksSchedule()//call weeks schedule
            4 -> showMonths()//call months
        }

    }

    fun makeEntry(){


        //TODO: add a time option
        var stringPrompt = """
            Make an entry:
            Format is DD/MM<space>entry
        """.trimIndent()



        //TODO: change the color of this text to green
        println("Make a Schedule Entry")
        println(stringPrompt)
        var entryFromTerminal = readLine()

        //TODO: create a check on the input
        //checks if entry is empty
        //not in format
        var dateAndEntryArray = entryFromTerminal!!.split(" ",limit = 2)
        var dateAndMonth = dateAndEntryArray[0]
        var ( date , month) = dateAndMonth.split("/")
        var entry = dateAndEntryArray[1]

        transaction {

            entryModel!!.makeAnEntry( date.toInt(),month.toInt(),entry)

        }



    }

    fun showTodaysSchedule(){


        val currentDate  = LocalDate.now()

        var ( year , month , date) = currentDate.toString().split("-")

        //TODO:print todays date
        entryModel!!.makeQuery(date,month,year)
    }

    fun showWeeksSchedule(){

        //TODO: show each day's schedule , day should be a subtitle followed by tabbed schedules
    }

    fun showMonths(){
       // var calendarUtils = CalendarUtils()

        println("Months of the year")
        println(calendarUtils!!.months)

        //add checking input option
        println("select a month (1,2,..): ")
        var monthSelected = readLine()!!.toInt()
        calendarUtils!!.chooseMonthToPrint(monthSelected)


    }
}