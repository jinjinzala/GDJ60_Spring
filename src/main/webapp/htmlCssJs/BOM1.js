const btn = document.getElementById("btn");
const btn2 = document.getElementById("btn2");
const btn3 = document.getElementById("btn3");





btn.addEventListener("click", function(){
    let c2 = window.document.getElementById("c2");
    console.log(c2.innerText);
    console.log(c2.innerHTML);
    //c2.innerText ='test';
    c2.innerHTML='<img src="../resources/images/s1.jpg">';
})

let c1 = window.document.getElementById("c1");
// alert(c1);
 //console.log(c1);
console.log(c1.innerText);
console.log(c1.innerHTML);
//c1.innerText = "Change Text";


btn2.addEventListener("click",function(){
let c3 =  document.getElementById("c3");
let v = c3.title;
console.log(v);
//console.log(c3.innerText);

})

btn3.addEventListener("click",function(){
    console.log(input1);
    //console.log(c3.innerText);
    
    })



    

