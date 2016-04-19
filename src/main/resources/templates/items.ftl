<!DOCTYPE html>

<html lang="en">

<head>
    <title>Food Item List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="/style.css" />
</head>

<body>
   <div id="header">
      <h2>Food Item List</h2>
   </div>
   <div id="content">
     <fieldset>
       <legend>Add Item</legend>
       <form method="post">
         Name     : <input type="text" name="name" /><br/>
         Quantity : <input type="text" name="quantity" /><br/>
         <input type="submit" value="Save" />
       </form>
     </fieldset>
     <br/>
     <table class="datatable">
       <tr>
         <th>Category</th>
         <th>Name</th>
         <th>Quantity</th>
       </tr>
       <#list items as item>
         <tr>
           <td>${item.category}</td>
           <td>${item.name}</td>
           <td>${item.quantity}</td>
         </tr>
       </#list>
     </table>
   </div>

</body>

</html>

