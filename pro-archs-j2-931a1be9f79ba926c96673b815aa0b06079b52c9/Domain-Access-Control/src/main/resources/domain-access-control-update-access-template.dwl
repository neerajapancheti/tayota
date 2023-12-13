"An error has occurred in the following: \n
<b>Application: " ++ app.name as String ++ 
"\n</b>
Flow Name: " ++ vars.flowName as String ++
"\n<br>
The error was:\n" ++ if (error.message != null) error.message as String else "" ++
"\n<b>The Correlation ID was: </b>" ++ vars.requestAttributes.headers.client_correlationid as String ++
"\n<b>Required Actions:</b>
<ul><li> Log into CloudHub and search for that Correlation ID </li><li> Raise Service Desk Ticket </li><li> Contact Internal Mulesoft Team </li></ul>"
