const fetch = require('node-fetch')
const co = require('co')

let hello = new Promise((resolve) => {
    if (Math.random() > .5)
        resolve("Hello ")
    else
        resolve("Goodbye ")
}).then(s => new Promise((resolve) => {

    if (Math.random() > .5)
        setTimeout(() => resolve(`${s} Christian`),500)
    else
        setTimeout(() => resolve(`${s} Viola`),500)
})).then(console.log);

//fetch('http://jsonplaceholder.typicode.com/posts/1').then(response => response.json()).then(post => post.title).then(console.log)

co(function *() {
    const url = 'http://jsonplaceholder.typicode.com/posts/1'
    const response = yield fetch(url)
    const post  = yield response.json()
    const title = post.title
    console.log(title)
})