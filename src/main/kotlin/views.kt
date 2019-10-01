class Views {

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

        var monthsCalendar : String

       //will need something to process this
        var stringPrompt = """
            Make an entry:
            Format is DD/MM<space>entry
        """.trimIndent()

        // should be green in color
        println("Make a Schedule Entry")
        //printCalendar
        println(stringPrompt)
        readLine()
        //calling a method to take this and put in db


    }

    fun showTodaysSchedule(){

    }

    fun showWeeksSchedule(){

    }

    fun showMonths(){
        var calendarUtils = CalendarUtils()

        println("Months of the year")
        println(calendarUtils.months)

        //add checking input option
        println("select a month (1,2,..): ")
        var monthSelected = readLine()!!.toInt()
        calendarUtils.chooseMonthToPrint(monthSelected)


    }
}