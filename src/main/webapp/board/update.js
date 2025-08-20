console.log('update.js open');

const boardFind = async ( ) => { console.log( "boardFind exe")
    const bno = new URLSearchParams(location.search).get('bno');
    const response = await fetch( `/board/find?bno=${ bno }`);
    const data = await response.json();
    document.querySelector('.bcontent').innerHTML = data.bcontent;
}
boardFind();

const boardUpdate = async ( ) => { console.log( "boardUpdate exe");
    const bno = new URLSearchParams( location.search ).get('bno');
    const bcontent = document.querySelector('.bcontent').value;
    const obj = { "bno" : bno , "bcontent" : bcontent };
    const option = {
        method : "PUT", headers : {"Content-Type" : "application/json"}, body : JSON.stringify( obj )
    }
    const response = await fetch( "/board" , option );
    const data = await response.json();
    if( data == true ){
        alert('수정 성공');
        location.href=`/board/view.jsp?bno=${ bno }`
    }else{
        alert('수정 실패');
    }
}