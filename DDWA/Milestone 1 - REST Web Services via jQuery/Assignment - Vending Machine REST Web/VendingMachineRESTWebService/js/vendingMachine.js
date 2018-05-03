var dollar = 1.00;
  var quarter = .25;
  var dime = .10;
  var nickel = .05;
  // var penny = 1;
// ``
  var userMoney=0;

$(document).ready(function () {
  alert("Ready!");

  $("*").css("font-family", "Varela");


  $("h1").css("text-align", "center");
  $("h1").css("font-family", "Faster One");
  $("h1").css("color", "red");
  $("h1").css("font-size", "55px");
  
  $(".displayMoney").css("font-size", "55px");

  

  loadItems();

  moneyAdder();

  makePurchase();

});
  // error: function(){

  // }

  // $("p").css("text-align", "center");

  // $("row").css("border", "2px", "solid", "red");
  //
  // $(".addBorder").css("border", "2px", "solid", "red");
  //
  // $(".addBorder").css("outline", "2px", "solid", "red");

// $(".addBorder").css("border", "3px solid black");

// border: 3px solid black;


function moneyAdder(){
  // $("#addDollar").click(function(event){

    $(document).on("click", "#addDollar", function(event){
    event.preventDefault();
    userMoney += dollar;
    $("#addDollar").val(userMoney);
    $(".displayMoney").text(userMoney);
  });

  $("#addQuarter").click(function(event){
    userMoney += quarter;
    $("#addQuarter").val(userMoney);
    $(".displayMoney").text(userMoney);
  });

  $("#addDime").click(function(event){
    userMoney += dollar;
    $("#addDime").val(userMoney);
    $(".displayMoney").text(userMoney);
  });

  $("#addNickel").click(function(event){
    userMoney += dollar;
    $("#addNickel").val(userMoney);
    $(".displayMoney").text(userMoney);
  });
// proivde a class to div and use that for click event

}

function makePurchase(){
  $("#makePurchase").click(function(event){

    $.ajax({
      type: "POST",
      url: "http://localhost:8080/"+userMoney+"/item/"+id
    });
  });
}



function loadItems() {
    // var products = $("#products");


    $.ajax({
      url: "http://localhost:8080/items",
      method: "GET",
      // type:"GET",
      dataType: "json",
    }).done(function (itemArray) {
      $.each(itemArray, function (index, item) {
  
        // var id = item.id;
        // var name = item.name;
        // var price = item.price;
        // var quantity = item.quantity;
  
        // var createRow = '<div class = "col-md createdDiv">';
        //     createdRow += id + "" + name + "" + price + "" + quantity + "</div>";
  
        var htmlOutput = formatter(item);
      console.log(htmlOutput);
        
        $("#products").append(htmlOutput);
  
      });
  
  
    });

  }

function formatter(myItems) {

    var id = myItems.id;
    var name = myItems.name;
    var price = myItems.price;
    var quantity = myItems.quantity;

    var row =
    `<div class="col-md border" data-snackId="${id}"> <!-- Left side. For Title, Price, and Quantity Left-->
              
            <p>(${id})</p> <!--Snack number -->
    
            <div class="item">
              <p>(${name})</p>
              <p>$${price}</p>
              <p>${quantity} </p>
            </div>
            </div>
    
          `;
          console.log(row);
          return row;
  }