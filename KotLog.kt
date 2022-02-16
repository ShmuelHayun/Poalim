package com.cambium.vast.poalimassignment.Utils

class KotLog {

    val appTag = "PoalimApp"

    companion object {
        private var kotLog : KotLog? = null

        val instance: KotLog
            get() {
                if (kotLog == null)
                    kotLog = KotLog()

                return kotLog!!
            }
    }

    fun printToLogCat(message : String){
        val stackTrace = Thread.currentThread().stackTrace

        var logMessage = ""
        var className = ""
        var funName = ""
        var lineNumber = ""

        if(stackTrace.isEmpty()){
            logMessage ="$appTag -> Nothing to print"

        }else if(stackTrace.size > 4){
            className = "className : " + stackTrace[3].className
            funName = "funName : " + stackTrace[3].methodName
            lineNumber = "lineNumber : " + stackTrace[3].lineNumber
            //logMessage = "message : $message"

            logMessage = "$appTag -> className $className, : funName $funName, : lineNumber $lineNumber, : message $message"
        }

        println(logMessage)
    }
}