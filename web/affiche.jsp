<%-- 
    Document   : Newjsp
    Created on : 28 mars 2022, 11:23:42
    Author     : HP
--%>

<%@page import="java.util.Iterator"%>
<%@page import="pack.employe"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="myCss.css" type="text/css"/>
        
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>   <meta charset="UTF-8">
      
<style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');

body {
    font-family: 'Open Sans', sans-serif
}

.search {
    top: 6px;
    left: 10px
}

.form-control {
    border: none;
    padding-left: 32px
}

.form-control:focus {
    border: none;
    box-shadow: none
}

.green {
    color: green
}

</style>
</head>
<body>




<div class="container mt-5 px-2">
    <div class="mb-2 d-flex justify-content-between align-items-center">
        <div class="position-relative"> <span class="position-absolute search"><i class="fa fa-search"></i></span> <input class="form-control w-100" placeholder="Liste des login/passwords"> </div>
    </div>
    <div class="table-responsive">
        <table class="table table-responsive table-borderless">
            <thead>
                <tr class="bg-light">
                    <th scope="col" width="20%">Login</th>
                    <th scope="col" width="20%">Password</th>
                    <th scope="col" width="20%">Avatar</th>
                </tr>
            </thead>
            <tbody>
                <%
            LinkedList<employe> L = (LinkedList<employe>)session.getAttribute("liste");
            
            for(employe u : L) {
             %>

                <tr>
                   
                    <td><%=u.getLogin()%></td>
                    <td><%=u.getPassword()%></td>
                    <td><img src="img/<%=u.getProfile()%>.jpg" width="25"> <%=u.getLogin()%></td>
                   
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
                        <a href="index.html">
<button type="submit" class="btn btn-primary theme-button mt-4">index</button>
</a>
</div>



</body>
</html>


