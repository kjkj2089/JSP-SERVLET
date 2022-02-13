'use strict';

//promise is a JavaScript object for asynchronous operation.
//State : pending -> fulfilled or rejected
//Producer vs Consumer

//1. Producer
//when new Promise is created, the executor runs automatically.
const promise = new Promise((resolve, reject) => {
    //doing some heavy work(network, read files)
    console.log('doing someting...');
    setTimeout(()=> {
        resolve('ellie');
        //reject(new Error('no network'));
    }, 2000);
});

//2. Consumers: then, catch, finally
promise.then((value) =>{ //성공했을때
    console.log(value);
})
.catch(error =>{ //실패했을때
    console.log(error);
})
.finally(()=> { //성공, 실패 상관없이 무조건 실행
    console.log('finally');
});

//3. Promise chaining
const fetchNumber = new Promise((resolve,reject) =>{
    setTimeout(() => resolve(1), 1000);
});

fetchNumber
.then(num => num * 2)
.then(num => num * 3)
.then(num => {
    return new Promise((resolve,reject)=>{
        setTimeout(()=> resolve(num-1),1000);
    });
})
.then(num => console.log(num));

//4. Error Handling
const getHen = () =>
new Promise((resolve, reject) => {
    setTimeout(()=> resolve(`🐓`), 1000);
});
const getEgg = hen =>
new Promise((resolve, reject) => {
    setTimeout(()=> reject(new Error(`${hen} =>🥚 `)), 1000);
});
const cook = egg =>
new Promise((resolve, reject) => {
    setTimeout(()=> resolve(`${egg} => 🍳`), 1000);
});

getHen()
.then(getEgg)
.catch(error => {
    return '🥖'
})
.then(cook)
.then(console.log)
.catch(console.log);
