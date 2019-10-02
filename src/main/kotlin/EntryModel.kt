import EntryModel.Entries.entry
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
//import org.jetbrains.exposed.sql.transactions.TransactionManager.Companion.manager
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
//import sun.rmi.transport.Connection
import java.util.*



class EntryModel {

    init {
        Database.connect("jdbc:sqlite:file:test.db", driver = "org.sqlite.JDBC")

       // TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE

        transaction {
            // print sql to std-out
            addLogger(StdOutSqlLogger)

            SchemaUtils.create (Entries)

//            // insert new city. SQL: INSERT INTO Cities (name) VALUES ('St. Petersburg')
//            val stPete = City.new {
//                name = "St. Petersburg"
//            }
//
//            // 'select *' SQL: SELECT Cities.id, Cities.name FROM Cities
//            println("Cities: ${City.get(1).name}")
        }
    }



    object Entries: IntIdTable() {
        val schedule_date = integer("schedule_date")
        val schedule_month = integer("schedule_month")
        val schedule_year = integer("schedule_year")

        val entry = text("entry")
        val dateCreated = datetime("creation_date")
    }



    class Entry(id: EntityID<Int>) : IntEntity(id) {
        companion object : IntEntityClass<Entry>(Entries)

        var schedule_date by Entries.schedule_date
        var schedule_month by Entries.schedule_month
        var schedule_year by Entries.schedule_year

        var entry by Entries.entry
        var dateCreated by Entries.dateCreated
    }

    fun makeAnEntry(date: Int , month: Int, entry: String,year: Int = 2019  ){

        transaction {

           // Database.connect("jdbc:sqlite:entries.db", driver="")
            addLogger(StdOutSqlLogger)

            //SchemaUtils.create (Entries)
            var newEntry = Entry.new{
                schedule_date = date
                schedule_month = month
                schedule_year = year

                this.entry = entry
                dateCreated = DateTime.now()
            }

//            printEntry()
        }
    }

    fun printEntry(){
       transaction {
            //Database.connect("jdbc:sqlite:test.db", driver = "org.sqlite.JDBC")
            //addLogger(StdOutSqlLogger)
           // SchemaUtils. (Entries)
            println("${Entry.get(1).entry}")

        }

    }
}





