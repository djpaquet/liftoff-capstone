
/*
$("#add-ingredient").click(function(event){
    event.preventDefault();
    addIngredient();
    )};

function addIngredient(){

    var $lastIngredient = $("#ingredient-area:last");

    var lastId = $lastIngredient.children().first().attr("id").match("\\d+")[0];

    // increment new id
    var newId = (parseInt(lastId) + 1).toString();

    var $newIngredient = $lastIngredient.clone();


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


*/

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
    //$newIngredient.children().first().children().first().remove();


    // replace id and name to be of the new id
    var regex1 = new RegExp("ingredients" + lastId, "g");
    var regex2 = new RegExp("\\[" + lastId + "\\]", "g");
    var newHtml = $newIngredient.html().replace(regex1, "ingredients" + newId).replace(regex2, "[" + newId + "]");

    $newIngredient.html(newHtml);
    //$newIngredient.before($lastIngredient);
    $lastIngredient.before($newIngredient);
}