console.log( 'view.js open' );

const boardFind = async()=>{ console.log( 'boardFind exe' );
    const url = new URLSearchParams( location.search );
    const bno = url.get('bno');
    const response = await fetch( `/board/find?bno=${bno}` );
    const data = await response.json();
    const bcontentBox = document.querySelector('.bcontentBox');
    const bwriterBox = document.querySelector('.bwriterBox');
    const bcontent = data.bcontent;
    const bwriter = data.bwriter;
    bcontentBox.innerHTML = bcontent;
    bwriterBox.innerHTML = bwriter;
}
boardFind(); 

const boardDelete = async ()=>{ console.log('boardDelete exe')
    const bno = new URLSearchParams( location.search ).get('bno');
    let check = confirm('정말 삭제 할까요?');
    if( check == true ){
        const option = { method : "DELETE" }
        const response = await fetch( `/board?bno=${bno}` , option );
        const data = await response.json();
        if( data == true ){ 
            alert('삭제 성공'); 
            location.href="/board/list.jsp"
        }else{
            alert('삭제 실패');
        }
    }
}
const boardUpdateView = ()=>{
    const bno = new URLSearchParams(location.search).get('bno');
    location.href=`/board/update.jsp?bno=${bno}`
}