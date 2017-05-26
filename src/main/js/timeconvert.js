function TimeConvert(num) {
    var div = Math.floor(num/60);
    var rem = num % 60;
    return '' + div +':' +rem;

}



console.log(TimeConvert(126));