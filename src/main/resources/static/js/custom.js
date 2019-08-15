$(document).ready(function(){
$('#addInstructions').click(function (){



event.preventDefault()
$('#instruction-area').append('<input class="form-control" id="instruction" th:type="text-area" th:field="*{instructions}" />'+
'<input class="btn btn-danger btn-sm" type="button" value="delete" id="delete" />');
});


/*$('#delete').click(function (){
$('#instruction-area').remove('<input class="form-control" id="instruction" th:type="text-area" th:field="*{instructions}" />)

    });*/


});

