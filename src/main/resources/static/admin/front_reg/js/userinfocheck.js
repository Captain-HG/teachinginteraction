function emailCheck(emailStr) {
    var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-]{2,4})+/;
    if (!pattern.test(emailStr)) {
        return false;
    } else {
        return true;
    }
}