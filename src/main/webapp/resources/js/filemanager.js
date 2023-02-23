//const fileList = document.getElementById("fileList");
const add = document.getElementById("add");

const fileAdd = document.getElementById("fileAdd");
const fileList = document.getElementById("fileList");
let count = 0;
let max = 5;
let param ='pic';

function setParam(p){
    param='p';
}

function setMax(m) {
    max = m;
}
add.addEventListener('click', function() {

    if(count >= max){
        alert('첨부파일은 최대 '+ max + '개만 가능합니다');
        return;
    }

    count++;

    //element text 들을 조합 
    let d = document.createElement('div');
    let l = document.createElement('label');
    let i = document.createElement('input');
    let t = document.createTextNode('image');

    console.log('fileAdd');
    //element들을 조합 
    d.appendChild(l);
    d.appendChild(i);
    l.appendChild(t);

    let attr = document.createAttribute('class');
    attr.value='mb-3';
    d.setAttributeNode(attr);

    //label
    attr = document.createAttribute('class'); 
    attr.value = 'form-label';
    l.setAttributeNode(attr);


    attr = document.createAttribute('for'); 
    attr.value = 'files';
    l.setAttributeNode(attr);

    attr =document.createAttribute("type");
    attr.value ="file";
    i.setAttributeNode(attr);
    fileList.append(d);

    attr = document.createAttribute('class'); 
    attr.value = 'form-control';
    i.setAttributeNode(attr);

    attr = document.createAttribute('id'); 
    attr.value = 'files';
    i.setAttributeNode(attr);

    attr = document.createAttribute('name'); 
    attr.value = 'param';
    i.setAttributeNode(attr);

    

    // if(fileList.length != 1) {
    //     console.log("파일업로드는 1개만 가능해욧!")
    // }







});