document.addEventListener("DOMContentLoaded", function() {
    const userId = 1; // 임시로 userId를 1로 고정

    function checkQuizPassed(quizId, elementId) {
        fetch(`/api/quizPassed/${quizId}/${userId}`)
            .then(response => response.json())
            .then(isPassed => {
                if (isPassed) {
                    const testSpot = document.getElementById(elementId);
                    testSpot.querySelector('.component_frame_top').style.backgroundColor = '#00f846';
                    testSpot.querySelector('.test_spot_compo_left').style.backgroundColor = '#02bd37';
                    testSpot.querySelector('.test_spot_compo_right').style.backgroundColor = '#00dd3f';
                }
            })
            .catch(error => console.error('Error checking quiz status:', error));
    }

    function checkAllQuizzesPassed() {
        fetch(`/api/allQuizzesPassed/${userId}`)
            .then(response => response.json())
            .then(allPassed => {
                if (allPassed) {
                    document.querySelector('.component_flag').style.display = 'block';
                }
            })
            .catch(error => console.error('Error checking all quizzes status:', error));
    }

    // 각 퀴즈 통과 여부 확인
    checkQuizPassed(1, 'test_1');
    checkQuizPassed(2, 'test_2');
    checkQuizPassed(3, 'test_3');
    checkQuizPassed(4, 'test_4');
    checkQuizPassed(5, 'test_5');

    // 모든 퀴즈 통과 여부 확인
    checkAllQuizzesPassed();
});