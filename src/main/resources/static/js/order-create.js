$(document).ready(function() {
    $('#data').dataTable( {
        "columnDefs": [
            { "orderable": false, "targets": 0 }
        ]
    } );

    t.on( 'order.dt search.dt', function () {
        t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    } ).draw();
});