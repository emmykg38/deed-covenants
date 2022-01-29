
function auto() {
    function stopEnterFromSubmittingForm(elementId) {
        google.maps.event.addDomListener(elementId, "keydown", function(event) {
            if (event.keyCode === 13){
                event.preventDefault();
            }
        });
    }

    function getAutocompleteData() {
        autocompleteRequest =
        {
            componentRestrictions: {'country': ['us']},
            fields: ['geometry', 'name', 'formatted_address']
        }

        new google.maps.places.Autocomplete(document.getElementById("addressInput"), autocompleteRequest);
        new google.maps.places.Autocomplete(document.getElementById("searchInput"), autocompleteRequest);

        stopEnterFromSubmittingForm(document.getElementById("addressInput"));
        stopEnterFromSubmittingForm(document.getElementById("searchInput"));
    }

    getAutocompleteData();

}