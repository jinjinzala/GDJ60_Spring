//비밀번호가 일치하는지 확인하는 구문 만들기
console.log("되는지 확인")


const memberName = document.getElementById("memberName");
const memberPhone = document.getElementById("memberPhone");
const email = document.getElementById("email");
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const idResult = document.getElementById("idResult");
const pwResult = document.getElementById("pwResult");
const pwResult2 = document.getElementById("pwResult2");


const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

//전체 폼 검증하는 변수 
let idcheck = false;
let pwcheck = false;
let pwNullCheck = false;
let pwEqualCheck = false;

//let checks = [false,false,false,false]
//checks[]=true;
//checks[0]=false;checks[1]=true;
//checks[0]=false;checks[1]=false;checks[2]=true;


//

id.addEventListener("blur",function(){
    if(id.value.length !=0){
        idResult.innerHTML="";
        idcheck = true;
    }else {
        idResult.innerHTML="아이디는 필수사항입니다"   
    }
});

pw.addEventListener("keyup",function(){
    if(pw.value.length >5 && pw.value.length < 13 ){
        pwResult.innerHTML="pw의 값은 6글자이상 12글자 이하여야합니다"
        pwcheck=true;
    }else {
        pwResult.innerHTML="좋아요!"
        //checks[2]=false;
    }
});


pw.addEventListener("change",function(){
    checks[3]=false;
    pwCheck.value='';
    pwCheck.innerHTML='pw가틀립니다'
});


// pw.addEventListener("blur",function(){
//     if(pw.value.length == ''){
//         pwResult.innerHTML="비밀번호는 필수입력입니다"
//     }else {
//         pwResult.innerHTML=""
//         pwNullCheck = true;
//     }
// });

//pw 같은지 아닌지 확인
pwResult2.addEventListener("blur",function(){
    if(pwResult2.value == pwResult.value){
        pwResult2.innerHTML = "동일한 패스워드 입니다"
        //pwNullCheck = true;
    }else {
    pwResult2.innerHTML = "pw가 틀립니다"    
    }

});

memberName.addEventListener("click",function(){
    if(memberName.length = 0) {
        alert('이름은 필수입니다');
    }
});

//form
btn.addEventListener ("click", function(){
    if(idcheck && pwEqualCheck && pwNullCheck && pwcheck){
        alert("회원가입성공");
    //frm.submit();
    }else{
        alert("회원가입성공x");
    }
});


// //form 배열을 이용하는 방법
// btn.addEventListener ("click", function(){
//     if(!checks.includes(false)) {
//         alert("회원가입성공");
//     //frm.submit();
//     }else{
//         alert("회원가입성공x");
//     }
// });