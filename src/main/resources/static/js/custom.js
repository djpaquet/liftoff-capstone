var max_fields      = 20;
var wrapper         = $("#ingredient-area");
var add_button      = $("#add_ing_button");
var total_fields = 0;
var index = 0

$(add_button).click(function(e){
    e.preventDefault();
    if(total_fields < max_fields){

        total_fields++;

        $(wrapper).append('<div class="row" id="ingredient-area">'+'<div class="col" th:for="ingredientName">'+
                                           '<input id="ingredientName" class="form-control" th:type="text" th:object="${ingredients}" th:field="*{ingredientName}" placeholder="Name" name="ingredientName"/>'+
                                          '<span th:error_ing="*{ingredientName}" class="errors"></span>'+
                                       '</div>'+
                                       '<div class="col-sm-2">'+
                                           '<input id="ingredientAmount" class="form-control" th:type="text" th:object="${ingredients}" th:field="*{ingredientAmount}" name="ingredientAmount" />'+
                                           '<span th:error_ing="*{ingredientAmount}" class="errors"></span>'+
                                       '</div>'+
                                       '<div class="col">' +
                                           '<input id="measurementUnit" class="form-control" th:type="text" th:object="${ingredients}"  th:field="*{amountMeasurement}" placeholder="cup, oz, each, etc" name="measurementUnit"/>'+
                                           '<span th:error-ing="*{ingredientAmount}" class="errors"></span>'+
                                       '</div>'+
                                       +'<div class="col">'+
                                           '<input id="ingredientDescription" class="form-control" th:type="text" th:object="${ingredients}" th:field="*{ingredientDescription}" placeholder="Description" name="ingredientDescription"/>'+
                                           '<span th:error_ing="*{ingredientDescription}" class="errors"></span>'+
                                       '</div>'+'</div>')};


});
   $(wrapper).on("click",".remove_ing_button", function(e){
        e.preventDefault();
 $(this).parent('<div class="row" id="ingredient-area">').remove(); //remove inout field
    x--; //inout field decrement
    });


