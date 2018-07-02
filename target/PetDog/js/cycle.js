window.onload = function(){
    var wrap = document.getElementById('wrap'),
        pic = document.getElementById('pic'),
        list = document.getElementById('list').getElementsByTagName('li'),
        index = 0,
        timer = null;

    if (timer) {
        clearInterval(timer);
        timer = null;
    }

    timer = setInterval(autoPlay, 2000);

    function autoPlay() {
        index++;
        if (index >= list.length) {
            index = 0;
        }
        changeImg(index);
    }

    function changeImg(curIndex) {
        for (var j = 0; j < list.length; j++) {
            list[j].className = "";
        }
        list[curIndex].className = "on";
        pic.style.marginTop = -305 * curIndex + "px";
        index = curIndex;
    }

    wrap.onmouseover = function() {
        clearInterval(timer);
    }

    wrap.onmouseout = function() {
        timer = setInterval(autoPlay, 2000);
    }


    for (var i = 0; i < list.length; i++) {
        list[i].id = i;
        list[i].onmouseover = function() {
            clearInterval(timer);
            changeImg(this.id);
        }
    }
}
