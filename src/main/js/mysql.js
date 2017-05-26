const mysql = require('mysql')
const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "my-secret-pw",
    database: "TOA"
})


/* Initialization part ends here */

/* Handler function starts here */

const merge = (a,b) => {
    return Object.assign({},a,b)
}

async function doThing() {
    const recipes =  new Promise((accept, reject) => {

        connection.query('SELECT * FROM Recipes', (error, results) =>  {
            return error && reject(error) || accept(results)

        })
    })
    const ingredients =  new Promise((accept, reject) => {

        connection.query('SELECT * FROM Ingredients', (error, results) =>  {
            return error && reject(error) || accept(results)

        })
    })

    const join =  new Promise((accept, reject) => {

        connection.query('SELECT * FROM RecipeIngredients', (error, results) =>  {

            return error && reject(error) || accept(results)

        })
    })
    let all = Promise.all(recipes,ingredients,join);
    all.onFulfilled = ([r,i,t]) => console.log(r,i,t)
    return  await all
}

doThing()