
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guest Book</title>
    </head>
 
    <body style=" background-image: url(1234.jpg)">
        <h1>Please, leave an impression</h1>
        <div>
        <form:form action="impression.htm" method="POST" commandName="impression">
            <form:label  path="username">Enter you username: </form:label><br>
        <form:input id="name" type="text" path="username" placeholder="Enter your name..."></form:input><br>
        
        <form:label path="text" >Enter you impression: </form:label><br>
        <form:textarea id="impression" path="text" placeholder="Your impression..." rows="4" cols="20" ></form:textarea><br>   
        <input type="submit" value="Submit"/>
        </div><br>
        </form:form>
        <div style=" font-style:  oblique; font-size:  x-large; font-weight: bolder" >
            <label for="impression_list" id="impresion_list_label">All impressions:</label><br>
            <textarea id="impression_list" rows="10" cols="50">${impressions}</textarea>
        </div>
        
    </body>

    
       
</html>
