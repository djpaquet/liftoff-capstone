$(document).ready(function(){
$('#addInstructions').click(function (e){

event.preventDefault()
$('#instruction').append('<div><input id="instructions" th:type="text-area" th:field="*{instructions}">'+
'<input type="button" value="delete" /></ div>');
}):

$('body').on('click','#delete',function (e){
    $(this).parent('div').remove();

});

});