const replyAdd = document.getElementById('replyAdd');
const replyContents =document.getElementById('replyContents');
const commentListResult = document.getElementById('commentListResult');
// const pageLink = document.querySelectorAll(".page-Link");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal =document.getElementById("closeModal")


//댓글 등록 
replyAdd.addEventListener("click", function(){
    console.log("num :"+replyAdd.getAttribute('data-book-booknumber'))
    // fetch(url, [options])
    // - url : 요청 URL
    // - options : method나, header등 지정

    //js에서 사용할 가상의 form 태그 생성 
    const form = new FormData(); // <form></from>
    //form 태그 내부에다가 추가하는 것 
    form.append("contents",replyContents.value); // <form><input type="text" name="contents" value="dfds"> <form>
    form.append("bookNumber",replyAdd.getAttribute('data-book-booknumber')) //name태그 추가한거 




    fetch('../bankBookComment/add',{
        method:'POST',
        headers : {},
        body: form, //"contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-booknumber')
    }).then((response) =>  response.text())
      .then((res) => {
             if(res.trim()==1){
             alert('댓글이 등록 되었습니다')
             replyContents.value="";
             getList(1);
             }else { 
             alert('댓글 등록에 실패 했습니다')
            }
            }).catch(()=>{
                alert('에러 발생 확인요망! ')
            }); 



    //구버전 
    // let xhttp = new XMLHttpRequest();

    // xhttp.open("POST", "../bankBookComment/add");

    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    // xhttp.send("contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-booknumber'));

    // xhttp.addEventListener('readystatechange', function(){
    //     if(this.readyState==4&&this.status==200){
    //         if(this.responseText.trim()==1){
    //             alert('댓글이 등록 되었습니다')
    //             replyContents.value="";
    //             getList(1);
    //         }else {
    //             alert('댓글 등록에 실패 했습니다')
    //         }

    //     }
    // })


})



getList(1);
//page 매개변수 선언 (앞에 let 붙이지 않음 )
function getList(page){
    
    // fetch(url, [options])
    // - url : 요청 URL
    // - options : method나, header등 지정


    fetch("/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-booknumber')+"&page="+page,{
        method : "GET"
    }).then((response) =>  response.text())
    .then((res) => {
        commentListResult.innerHTML=res.trim();
       }); 
    
    // let xhttp = new XMLHttpRequest();

    // let count = 0;

    // xhttp.open("GET","/bankBookComment/list?bookNumber="+replyAdd.getAttribute('data-book-booknumber')+"&page="+page);

    // xhttp.send();

    // xhttp.addEventListener('readystatechange',function(){
    //     if(this.readyState == 4 && this.status == 200){
    //         commentListResult.innerHTML = this.responseText.trim();
    //         count++
    //     }
    // })
    // // 0이 출력 : 비동기 방식이기 때문
    // console.log("count :"+count);
}


//안 찍힘 
// pageLink.forEach(function(p){
// console.log("p : ",p);
// });

//page
commentListResult.addEventListener("click",function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page = pageLink.getAttribute("data-board-page")
        getList(page);

    }
    e.preventDefault();

})

//delete
commentListResult.addEventListener("click",function(e){
    let del = e.target;
    if(del.classList.contains("del")){
         let res = fetch("../bankBookComment/delete",{
            method : 'POST',
            headers : {
                "Content-type" : "application/x-www-form-urlencoded"
            },
            body : "num="+del.getAttribute("data-comment-num")
            //응답객체에서 data 추출 
        }).then((response)=> {return response.text()})   //then(function(response){return response.text()})
        //추출한 데이터를 사용 
        .then((res)=>{
            if(res.trim()>0){
                alert("댓글 삭제")
                getList(1)
            }else{
                alert("실패")
            }
        }).catch(()=> {
            alert("삭제실패")
        })




        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST","../bankBookComment/delete") 
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+del.getAttribute("data-comment-num"));
        // xhttp.addEventListener("readystatechange",function(){
        //     if(this.readyState==4&&this.stats==200){
        //         let result = this.responseText.trim();
        //         if(result > 0){
        //             alert("댓글이 삭제되었습니다");
        //             getList();
        //         }else{
        //             alert("삭제실패")
        //         }
        //     }
        // })
        // console.log('delete');

    }
    e.preventDefault();

})

//update
commentListResult.addEventListener("click",function(e){
    let updateButton = e.target;
    if(updateButton.classList.contains("update")){
        
        //console.log(updateButton.parentNode.);
        let num = updateButton.getAttribute("data-comment-num");
        let contents = document.getElementById("contents"+num) //td
        console.log(contents)
        let contentsTextArea =  document.getElementById("contents")
        console.log(contentsTextArea)
        contentsTextArea.value=contents.innerText;
        contentsConfirm.setAttribute("data-comment-num",num)
    }
    e.preventDefault();

});

function updateContents(){
    console.log('update',"../bankBookComment/update");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num="+num+"&contents="+contents.firstChild.value);
    xhttp.addEventListener("readystatechange",function(){
        if(this.readyState==4&&this.stats==200){
            let result = this.responseText.trim();
            if(result > 0){
                alert("수정성공");
                getList();
            }else{
                alert("수정실패")
            }
        }
    })

}


    contentsConfirm.addEventListener("click", function(){
        console.log("Update Post");
        let updateContents = document.getElementById("contents").value;
        let num = contentsConfirm.getAttribute("data-comment-num");

         // fetch(url, [options])
        // - url : 요청 URL
        // - options : method나, header등 지정
        fetch("../bankBookComment/update",{
            method : "POST",
            headers : {"Content-type" : "application/x-www-form-urlencoded"},
            body : "num="+num+"&contents="+updateContents
        }).then((response) =>{return response.text()}) 
        .then((res)=>{
            if(res.trim()>0){
                alert("댓글 수정")
                getList(1)
            }else{
                alert("실패")
            }
        }).catch(()=> {
            alert("삭제실패")
        })})

        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST", "../bankBookComment/update");
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+num+"&contents="+updateContents);
        // xhttp.addEventListener("readystatechange", function(){
        //     if(this.readyState==4&&this.status==200){
        //         let result = this.responseText.trim();
        //         if(result>0){
        //             alert('수정 성공');
        //             closeModal.click();
        //             getList(1);
        //         }else {
        //             alert('삭제 실패');
        //         }
    
        //     }        
        // })
   