(function(window,undefined){

    function preventLinkEvent(){
        var menus = window.document.querySelectorAll(".oms-menu a");
        for(var idx = 0;idx<menus.length;idx++){
            menus[idx].onclick = function(e){
                e.preventDefault();
            }
        }
    }

    preventLinkEvent();

})(window)