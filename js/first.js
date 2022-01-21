// bad
const ulElement = document.getElementsByTagName('ul')[0];
for(let i=0; i<10; i++) {
  ulElement.innerHTML += `<li> list${i} </li>`;
}
 
// good
const ulElement = document.getElementsByTagName('ul')[0];
let strHtml = ulElement.innerHTML;
for(let i=0; i<10; i++) {
  strHtml += `<li> list${i} </li>`;
}
ulElement.innerHTML = strHtml;