
$("#add-ingredient").click(function(event) {
    event.preventDefault();
    addIngredient();
});

function addIngredient() {

    var $lastIngredient = $("#ingredient-list:last");

    // get id of last ingredient-row
    var lastId = $lastIngredient.children().first().children().first().attr("id").match("\\d+")[0];

    // increment to new id
    var newId = (parseInt(lastId) + 1).toString();

    var $newIngredient = $lastIngredient.clone();


    // replace id and name to be of the new id
    var regex1 = new RegExp("ingredients" + lastId, "g");
    var regex2 = new RegExp("\\[" + lastId + "\\]", "g");
    var newHtml = $newIngredient.html().replace(regex1, "ingredients" + newId).replace(regex2, "[" + newId + "]");

    $newIngredient.html(newHtml);
    //$newIngredient.before($lastIngredient);
    $lastIngredient.before($newIngredient);
}

$("#addInstruction").click(function(event){
       event.preventDefault();
       addInstruction();
});

function addInstruction(){


     var $lastInstruction = $("#instruction-area:last");

     var lastId = $lastInstruction.children().first().attr("id").match("\\d+")[0];

     var newId = (parseInt(lastId) + 1).toString();

     var $newInstruction = $lastInstruction.clone();

     var regex1 = new RegExp("instructions" + lastId, "g");
     var regex2 = new RegExp("\\[" + lastId + "\\]", "g");

     var newHtml = $newInstruction.html().replace(regex1, "instructions" + newId).replace(regex2, "[" + newId + "]");

        $newInstruction.html(newHtml);
        $lastInstruction.before($newInstruction);

    }


