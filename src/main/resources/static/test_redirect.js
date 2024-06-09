document.addEventListener("DOMContentLoaded", function() {
    const quizDivs = document.querySelectorAll(".test_spot");

    quizDivs.forEach(div => {
        div.addEventListener("click", function() {
            const quizId = this.id.split('_')[1]; // "test_1"에서 숫자 1을 추출
            window.location.href = `/test_${quizId}`;
        });
    });
});
