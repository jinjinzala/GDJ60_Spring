const replyAdd = document.getElementById("replyAdd");
const replycontents = document.getElementById("replyContents");


replyAdd.addEventListener("click",function(){

let xhttp = new XMLDocument()


xhttp.open('GET','../bankBookComment/add')

xhttp.setRequetHeader("CONT")

xhttp.send("contents="+replycontents.value+"&bookNumber="+replyAdd.getAttribute('data-book-bookNum'));

xhttp.addEventListener('readystatechange', function(){
    if(this.readyState==4&&this.stats==200){
        if(this.reponseText.trim()==1){
            alert("댓글이 등록되었습니다")
            replycontents.value="";
        }else{
            alert("댓글이 등록되었습니다 ")
        }
    }

})

})

function getList(){
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET","/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-bookNum'))

    xhttp.send();
    xhttp.addEventListener("readystatechange",function(){
        if(this.readyState==4&&this.stats==200){
            console.log(this.responseText)
        }
    })
}