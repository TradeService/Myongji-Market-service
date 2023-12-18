$(document).ready(function() {
    $('.card').hover(
        function() {
            $(this).css({
                'transform': 'translateY(-5px)',
                'cursor': 'pointer'
            });
        },
        function() {
            $(this).css({
                'transform': 'translateY(0)'
            });
        }
    );
});
