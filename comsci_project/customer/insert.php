<?PHP
    include_once("connection.php");

if(isset($_POST['foodName']) && isset($_POST['foodPrice'])){
    $name = $_POST['foodName'];
    $price = $_POST['foodPrice'];

    $query = "INSERT INTO Restaurant_Food(food_name, food_price) 
    VALUES ('$name', $price)"; 
    
    $result = mysqli_query($conn, $query);

    if($result > 0){
        if(isset($_POST['mobile']) && $_POST['mobile'] == "android"){
            echo "success";
            exit;
        }
        echo "Insert Successfully";   
    }
    else{
        if(isset($_POST['mobile']) && $_POST['mobile'] == "android"){
            echo "failed";
            exit;
        }
        echo "Something Error";   
    }
}
    
?>
<html>
<head><title>Insert | KosalGeek</title></head>
    <body>
        <h1>Insert Food</h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
            Name <input type="text" name="Name" value=""/><br/>
            Price <input type="text" name="txtPrice" value=""/><br/>
            <input type="submit" name="btnSubmit" value="Insert"/>
        </form>
    </body>
</html>