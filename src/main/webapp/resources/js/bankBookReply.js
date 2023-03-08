//const replyAdd = document.getElementById('replyAdd');
const replyContents =document.getElementById('replyContents');
const commentListResult = document.getElementById('commentListResult');
// const pageLink = document.querySelectorAll(".page-Link");
const contentsConfirm = document.getElementById("contentsConfirm");
const closeModal =document.getElementById("closeModal")




//"contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-booknumber')
//j쿼리 사용 

$("#replyAdd").click(function(){
    //console.log("num :"+$("#replyAdd").getAttribute('data-book-booknumber'))
    const form1 = new FormData();
    form1.append("contents",$("#replyContents").val()); // <form><input type="text" name="contents" value="dfds"> <form>
    form1.append("bookNumber",$("#replyAdd").attr('data-book-booknumber')) //name태그 추가한거 
    
    fetch('../bankBookComment/add',{
        method:'POST',
        headers : {},
        body: form, }).then((response) =>  response.text())
      .then((res) => {
             if(res.trim()==1){
             alert('댓글이 등록 되었습니다')
             $("#replyContents").val="";
             getList(1);
             }else { 
             alert('댓글 등록에 실패 했습니다')
            }
            }).catch(()=>{
                alert('에러 발생 확인요망! ')
            }); 

      
})




//////////////////////////////////////////////////////////////

//댓글 등록 새로운 방법
// replyAdd.addEventListener("click", function(){
//     console.log("num :"+replyAdd.getAttribute('data-book-booknumber'))
//     // fetch(url, [options])
//     // - url : 요청 URL
//     // - options : method나, header등 지정

//     //js에서 사용할 가상의 form 태그 생성 
//     const form = new FormData(); // <form></from>
//     //form 태그 내부에다가 추가하는 것 
//     form.append("contents",replyContents.value); // <form><input type="text" name="contents" value="dfds"> <form>
//     form.append("bookNumber",replyAdd.getAttribute('data-book-booknumber')) //name태그 추가한거 




//     fetch('../bankBookComment/add',{
//         method:'POST',
//         headers : {},
//         body: form, //"contents="+replyContents.value+"&bookNumber="+replyAdd.getAttribute('data-book-booknumber')
//     }).then((response) =>  response.text())
//       .then((res) => {
//              if(res.trim()==1){
//              alert('댓글이 등록 되었습니다')
//              replyContents.value="";
//              getList(1);
//              }else { 
//              alert('댓글 등록에 실패 했습니다')
//             }
//             }).catch(()=>{
//                 alert('에러 발생 확인요망! ')
//             }); 

//         })

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
        //$("#commentListResult").html(res.trim())
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
// commentListResult.addEventListener("click",function(e){
//     let pageLink = e.target;
//     if(pageLink.classList.contains("page-link")){
//         let page = pageLink.getAttribute("data-board-page")
//         getList(page);

//     }
//     e.preventDefault();

// })


//j쿼리 사용해서 바꾸기
$("#commentListResult").on("click","page-link",function(e){
    let page = $(this).attr("data-board-page")
    getList(page);
    e.preventDefault();
})

//delete 이벤트위임 on j쿼리 이용해서 
$("#commentListResult").on("click","del",function(e){
    fetch("../bankBookComment/delete",{

        method : 'POST',
        headers : {
            "Content-type" : "application/x-www-form-urlencoded"
        },
        body : "num="+del.getAttribute("data-comment-num")
    }).then((response)=> {return response.text()})   //then(function(response){return response.text()})
    //추출한 데이터를 사용 
    .then((res)=>{
        if(res.trim()>0){
            alert("댓글 삭제")
            getList(1)
        }else{
            alert("실패")
        }
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
    e.preventDefault();
})

//update 구버전
// commentListResult.addEventListener("click",function(e){
//     let updateButton = e.target;
//     if(updateButton.classList.contains("update")){
        
//         //console.log(updateButton.parentNode.);
//         let num = updateButton.getAttribute("data-comment-num");
//         let contents = document.getElementById("contents"+num) //td
//         console.log(contents)
//         let contentsTextArea =  document.getElementById("contents")
//         console.log(contentsTextArea)
//         contentsTextArea.value=contents.innerText;
//         contentsConfirm.setAttribute("data-comment-num",num)
//     }
//     e.preventDefault();

// });

//////////////////j쿼리를 사용해서 만든 버전 /////////////////////////////////////////////////
$("#commentListResult").on("click","update",function(e){
       let num = $(this).attr("data-comment-num");
        $("contents").val($("#contents"+num).text())
        $("#contentsConfirm").attr("data-comment-num",num)
       e.preventDefault()
    })

////////////////////////////////////////////////////////////////////////////////////////////


// function updateContents(){
//     console.log('update',"../bankBookComment/update");
//     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//     xhttp.send("num="+num+"&contents="+contents.firstChild.value);
//     xhttp.addEventListener("readystatechange",function(){
//         if(this.readyState==4&&this.stats==200){
//             let result = this.responseText.trim();
//             if(result > 0){
//                 alert("수정성공");
//                 getList();
//             }else{
//                 alert("수정실패")
//             }
//         }
//     })

// }
//////////////////j쿼리를 사용해서 만든 버전 /////////////////////////////////////////////////
$("#contentsConfirm").click(function(){
   // let num = $(this).attr("data-comment-num");
    fetch("../bankBookComment/update",{
               method : "POST",
                 headers : {"Content-type" : "application/x-www-form-urlencoded"},
                 body : "num="+$(this).attr("data-comment-num")+$("#contents").val
            }).then((response) =>{return response.text()}) 
             .then((res)=>{
        if(res.trim()>0){
            alert("댓글 수정")
             getList(1)
           }else{
              alert("실패")
                 }
             })
            })



////////////////////////////////////////////////////////////////////////////////////////////

    // contentsConfirm.addEventListener("click", function(){
    //     console.log("Update Post");
    //     let updateContents = document.getElementById("contents").value;
    //     let num = contentsConfirm.getAttribute("data-comment-num");

    //      // fetch(url, [options])
    //     // - url : 요청 URL
    //     // - options : method나, header등 지정
    //     fetch("../bankBookComment/update",{
    //         method : "POST",
    //         headers : {"Content-type" : "application/x-www-form-urlencoded"},
    //         body : "num="+num+"&contents="+updateContents
    //     }).then((response) =>{return response.text()}) 
    //     .then((res)=>{
    //         if(res.trim()>0){
    //             alert("댓글 수정")
    //             getList(1)
    //         }else{
    //             alert("실패")
    //         }
    //     }).catch(()=> {
    //         alert("삭제실패")
    //     })})


        
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

        //테스트 후 삭제할 영역
        //const b1 = document.querySelector("#b1")
        //b1.addEventLisener("click"m funtion(){})
        //document.getElementById("t1").value
        //juery
        
        
        // $('#b1').click(()=>{
        //    let v = $('#t1').val()
        //    console.log(v);
        // });

        // // $("#t1").blur(()=>{
        // //     console.log("blur")

        // // })
        // $("#t1").on({
        //     click: function(){
        //         console.log("t1클릭")
        //     },
        //     blur:()=>{
        //         console.log("t1blur")
        //     }

        // });

    // // $("선택자").이벤트명(callback function)
    //     $("#b1").on("click",function(){

    //     })
    // //$("부모선택자").on("이벤트명", "자식선택자", callback function)
    //     $("#commentListResult").on("click",".update",function(){})
    //      const ch =  document.getElementsByClassName("ch")
    //     for(let c of ch){
    //         c.addEventListener("click",function(){})
    //     }

    //     $(".ch").click((e)=>{
    //         console.log("e",e)
    //         console.log(e.target)//.value)
    //       console.log($(e.target).val())
    //     })
        ///////////////////////////
   