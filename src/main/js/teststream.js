const {Readable} = require('stream');


function* nums() {
    for (i = 0; true; i++)
        yield `${i}`
}
const inStream = new Readable({
    read() {

        for (const val of nums()) {
            this.push(val)
        }

        this.push(null)
    }
});

inStream.pipe(process.stdout);