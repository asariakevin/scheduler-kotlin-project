import java.text.SimpleDateFormat
import java.util.*

class CalendarUtils {


     var months = """
        1. January          7. July
        2. February         8. August
        3. March            9. September
        4. April            10. October
        5. May              11. November
        6. June             12. December
    """.trimMargin()


    //TODO: print a month
    fun chooseMonthToPrint( month: Int){

        when( month){
            1 -> printMonth(1)
            2 -> printMonth(2)
            3 -> printMonth(3)
            4 -> printMonth(4)
            5 -> printMonth(5)
            6 -> printMonth(6)
            7 -> printMonth(7)
            8 -> printMonth(8)
            9 -> printMonth(9)
            10 -> printMonth(10)
            11 -> printMonth(11)
            12 -> printMonth(12)


        }

    }

    fun printMonth( month: Int) {

        var calendar = GregorianCalendar(2019,month,1)
        calendar.set(Calendar.DAY_OF_MONTH,1) //set tje day of month to 1
        var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) //get day of week for 1st of month
        var daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        //print month name and year
        println(SimpleDateFormat("MMMM YYYY").format(calendar.getTime()))
        println(" S  M  T  W  T  F  S")

        var initialSpace = ""
        var dayRange = 0..(dayOfWeek - 1)

        for ( i in dayRange){
            initialSpace += "  "
        }

        print(initialSpace)

        var i = 0
        var dayOfMonth = 1

        while ( dayOfMonth <= daysInMonth){
            var j = if (i == 0) dayOfWeek -1 else 0
            while ( j < 7 && (dayOfMonth <= daysInMonth)){
                print(dayOfMonth)
                dayOfMonth++
                j++
            }
            println()
            i++

        }



    }
}

//Calendar calendar = new GregorianCalendar(2014, 1, 06);
//calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
//int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //get day of week for 1st of month
//int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//
////print month name and year
//System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
//System.out.println(" S  M  T  W  T  F  S");
//
////print initial spaces
//String initialSpace = "";
//for (int i = 0; i < dayOfWeek - 1; i++) {
//    initialSpace += "   ";
//}
//System.out.print(initialSpace);
//
////print the days of the month starting from 1
//for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
//    for (int j = ((i == 0) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
//        System.out.printf("%2d ", dayOfMonth);
//        dayOfMonth++;
//    }
//    System.out.println();
//}
