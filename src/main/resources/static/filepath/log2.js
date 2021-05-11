<html>
<head><title>My Game</title>
<link href = "style.css" rel = "stylesheet" type = "text/css"/>
<!--<script src = "scripts.js" type = "text/javascript"></script>-->
<script src = "jquery-3.4.1.js"></script>
</head>
  
<body class = "bg" >
                <script src = "jquery-3.4.1.js"></script>
<table border = "0" >
<tr>
<th>
       <font color =#CCFFFF>Dyttonation</font> 
</th>
<th bgcolor = "#660099" heigth = "3opx" width = "25px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "23px" style= "border-radius :2px solid while" ></th>
<th bgcolor = "#660099" width = "20px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "18px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "15px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "13px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "10px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "7px" style= "border-radius :2px solid while"></th>
<th bgcolor = "#660099" width = "5px" style= "border-radius :2px solid while"></th>

</tr>
</table>



    <div>
            <form class = "myform" >
            
            <div class = "centerpage">
             
            <center><i><h4 style = "color:white "; >LOGIN</h4></i></center>
            <legend >   
                    <fieldset>
            
                            <br><br>
                    <input type = "text" name = "username"  placeholder="Username" id = "user" /><br><br><br>
                    <input type = "password" name = "password" placeholder="Password"  id = "pass" /><br><br>
                   <input type = "submit" value = "Login" id = "b"/>
                 <p id = "para"></p>
                </form>
          
                </fieldset>

            </legend>

                     
            </div>
                

    </div>
<script>

$(document).ready(function(){ 

$("#b").click(function()

  {
    //$("#para").text("Welcome Anjali");
       $u = $("#user").val;
       $p = $("$pass").val;

      if($u == "anjali" && $p == 123)
      {
        
          $("#para").text("Welcome Anjali");
      }
      else if($u == "" && $p == "")
      {
          $("#para").text("Please fill the fields");
          
      }
      else
      {

         $("#para").text("Invalid login");
      }


  });

});
</script>

</body>

</html>