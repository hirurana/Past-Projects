<?PHP
include_once("connection.php");

echo "this is update.php";

if(isset($_POST['mobile']) && $_POST['mobile'] == "android" && 
   isset($_POST['txtPid']) && isset($_POST['txtName']) && 
   isset($_POST['txtQty']) && 
   isset($_POST['txtPrice']) && isset($_POST['txtImageUrl'])){
    
    $pid = $_POST['txtPid'];
    $name = $_POST['txtName'];
    $qty = $_POST['txtQty'];
    $price = $_POST['txtPrice'];
    $image_url = $_POST['txtImageUrl'];

    $query = "UPDATE tbl_product 
        SET name='$name', qty=$qty, price=$price, image_url='$image_url' 
        WHERE pid=$pid";
    
    $result = mysqli_query($conn, $query);

    if($result > 0){
        echo "success";
        exit;
    }
    else{
        echo "failed";
        exit;
    }
}    
?>