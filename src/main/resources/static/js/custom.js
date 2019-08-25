/*
let addRow = function () {
        let listName = 'ingredients'; //list name in Recipe.class
        let fieldsNames = ['id', 'ingredientName', 'ingredientAmount', 'amountMeasurement', 'ingredientDescription']; //field names from Ingredient.class
        let rowIndex = document.querySelectorAll('.item').length; //we can add mock class to each ingredient-row

        let row = document.createElement('div');
        row.classList.add('row', 'item');

        fieldsNames.forEach((fieldName) => {
            let col = document.createElement('div');
            col.classList.add('col', 'form-group');
            if (fieldName === 'id') {
                col.classList.add('d-none'); //field with id - hidden
            }

            let input = document.createElement('input');
            input.type = 'text';
            input.classList.add('form-control');
            input.id = listName + rowIndex + '.' + fieldName;
            input.setAttribute('name', listName + '[' + rowIndex + '].' + fieldName);

            col.appendChild(input);
            row.appendChild(col);
        });

        document.getElementById('ingredientList').appendChild(row);
};*/

/*var max_fields      = 20;
var wrapper         = $("#ingredient-area");
var add_button      = $("#add_ing_button");
var total_fields = 0;
var index = 0

$(add_button).click(function(e){
    e.preventDefault();
    if(total_fields < max_fields){

        total_fields++;

        $(wrapper).append('<div class="form-check">'+'<div class="row">'+'<div class="col" th:for="ingredientName">'+
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
    });*/

$("#add-ingredient").click(function(event) {
    event.preventDefault();
    addIngredient();
});

function addIngredient() {
    var $lastIngredient = $("#ingredient-area:last");

    // get id of last ingredient-row
    var lastId = $lastIngredient.children().first().children().first().attr("id").match("\\d+")[0];

    // increment to new id
    var newId = (parseInt(lastId) + 1).toString();

    var $newIngredient = $lastIngredient.clone();

    // remove id and version hidden input nodes
    $newIngredient.children().first().children().first().remove();


    // replace id and name to be of the new id
    var regex1 = new RegExp("ingredients" + lastId, "g");
    var regex2 = new RegExp("\\[" + lastId + "\\]", "g");
    var newHtml = $newIngredient.html().replace(regex1, "ingredients" + newId).replace(regex2, "[" + newId + "]");

    $newIngredient.html(newHtml);
    $lastIngredient.after($newIngredient);
}

$("#add-step").click(function(event) {
    event.preventDefault();
    addStep();
});