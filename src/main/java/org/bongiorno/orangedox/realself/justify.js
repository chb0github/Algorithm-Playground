module.exports =  (str,len) => {
    if(str.length > len)
        throw new Error("String is longer than justification.")

    const parts = str.trim().split(' ')
    const numChars = parts.map(s => s.length).reduce((a,b) => a + b)


    var pad = ' '.repeat(Math.ceil((len - numChars) / parts.length))
    return parts.map(s => `${pad}${s}`).reduce((a, b) => a + b).trim()
}


