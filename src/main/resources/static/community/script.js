const loadAllCommunities = () => {
    cleanCommunities();
    let domain = window.location.origin;
    fetch(domain + '/community/controller')
        .then(response => response.json())
        .then(communities => {
            communities.forEach(community => {
                $("#communityGrid")
                    .append(
                        '<tr>' +
                        '<td>' + '<a href="/community/community.html?id=' + community.id + '">' + community.id + '</a>' + '</td>' +
                        '<td>' + community.name + '</td>' +
                        '</tr>');
            });
        })
}

const loadCommunityById = () => {
    cleanCommunities();
    let domain = window.location.origin;
    let url = window.location.href;
    let id = url.substring(url.lastIndexOf('=') + 1);
    fetch(domain + '/community/controller/' + id)
        .then(response => response.json())
        .then(community => {
            $("#communityGrid")
                .append(
                    '<tr>' +
                    '<td>' + community.id + '</td>' +
                    '<td>' + community.name + '</td>' +
                    '</tr>');
        });
}

const createNewCommunity = () => {
    let domain = window.location.origin;
    const newCommunity = {
        id: $("#newCommunityId").val(),
        name: $("#newCommunityName").val()
    };
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(newCommunity)
    };
    fetch(domain + '/community/controller', requestOptions)
        .then(response => response.json())
        .then(data => alert('New community: ' + JSON.stringify(data) + ' been added!'))
        .catch(error => alert('Error occurred during saving new community: ' + JSON.stringify(error)));
}

const cleanCommunities = () => {
    $("#communityGrid").empty();
}

const reloadPage = () => {
    cleanCommunities();
}




/*

const loadEmployeesByLetters = () => {
    cleanEmployees();
    let domain = window.location.origin;
    let letters = $("#getEmployeeByLetters").val();
    fetch(domain + '/employees/' + letters)
        .then(response => response.json())
        .then(employees => {
            employees.forEach(employee => {
                $("#employeeGrid")
                    .append(
                        '<tr>' +
                        '<td>' + '<a href="' + domain + '/employee.html?id=' + employee.employeeId + '">' + employee.employeeId + '</a>' + '</td>' +
                        '<td>' + employee.firstName + '</td>' +
                        '<td>' + employee.lastName + '</td>' +
                        '</tr>');
            });
        })
}




const loadAllCitizens = () => {
    let domain = window.location.origin;
    fetch(domain + '/citizens')
        .then(response => response.json())
        .then(citizens => {
            citizens.forEach(user => {
                $("#citizenGrid")
                    .append('<li class="list-group-item">' +
                        '<div>' + user.firstname + '</div>' +
                        '<div>' + user.id + '</div>' +
                        '<div>' + user.address + '</div>' +
                        '<div>' + user.country + '</div>' +
                        '</li>');
            });
        })
}

const loadAllCountries = () => {

    let domain = window.location.origin;
    fetch(domain + '/countries')
        .then(response => response.json())
        .then(countries => {
            countries.forEach(country => {
                $('#allCountriesId').append($('<option>', {
                    text: country.name
                }));
            });
        })
}

const addNewCitizen = () => {
    const newUser = {
        firstname: $("#newCitizenNameId").val(),
        id: $("#newCitizenId").val(),
        address: $("#newCitizenAddressId").val(),
        country: $('#allCountriesId').find(":selected").val()
    };
    const requestOptions = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(newUser)
    }
    let domain = window.location.origin;
    fetch(domain + '/citizens', requestOptions)
        .then(response => response.json())
        .then(data => alert('new citizen: ' + JSON.stringify(data) + ' been added!'))
        .catch(error => alert('error occured during saving new citizen: ' + JSON.stringify(error)));
}



const cleanCitizens = () => {
    $("#citizenGrid").empty();
}*/
