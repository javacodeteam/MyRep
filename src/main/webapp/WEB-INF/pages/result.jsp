<%@page isELIgnored="false" %>
<h3 style="color:red;text-align:center">Result page</h1>



 Uploaded File1::: ${file1} <br>
 Uploaded File2::: ${file2} <br>
 
 <br><a href="register.do">Register</a>
 <%
    response.setContentType("application/vnd.ms-excel");
    response.addHeader("Content-Disposition","attachment;fileName=tile.xls"); 
  %>
 
 