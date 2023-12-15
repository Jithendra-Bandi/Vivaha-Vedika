const form = document.getElementById("form");
const applyBtn = document.getElementById("applyBtn");
const filter = document.getElementById("filter");
// const cancelBtn = document.getElementById("cancelBtn")
const filterBtn = document.getElementById("filterBtn");
const showCase = document.getElementById("showCase");
const occupationPlace = document.getElementById("occupationPlace");
const occupationState = document.getElementById("occupationState");
const allProfilesUrl = "http://localhost:8080/profiles";
const filterProfilesUrl = "http://localhost:8080/filter";




function getRequest(url,options={method:"GET"}) {
    fetch(url, options)
    .then(response => response.json())
    .then(profiles => {
        let profile = "";
        profiles.forEach(data => {
            profile += ` <div class="profile-container mb-3 p-2">
            <div>
                <img src="data:image;base64,${data.image}" class="profile-image w-100">
            </div>
    
            <div class="details">
                <h4>${data.firstName} ${data.lastName}</h4>
                <span>Profile No: <b>${data.id}</b></span>
                <li>${data.birthDate}-${data.birthMonth}-${data.birthYear} ${data.feet}'${data.inch}" ${data.rasiNakshitram}</li>
                <li>${data.casteGeneral}- ${data.caste} ${data.subCaste}</li>
                <li>${data.education}</li>
                <li>${data.occupation} ${data.occupationRole}, ${data.salary}</li>
                <li>${data.cityName} ${data.occupationState} ${data.countryName}</li>
                <li>${data.village}, ${data.apDistrict}, ${data.nativeState}</li>
                <li>${data.maritialStatus}</li>

            </div>
            
        </div>`;
        })
showCase.innerHTML=profile
    })
    .catch(err=>console.log(err)); 
}
getRequest(allProfilesUrl);





occupationPlace.addEventListener("change", event => {
    if (event.target.value === "India") {
        occupationState.classList.remove("d-none");
    }
    else {
        occupationState.classList.add("d-none");
        occupationState.value="";
    }
})

for (let i = 1970; i <= 2005; i++) {
    let option = document.createElement("option");
    option.value = i;
    option.textContent = i;
    year.appendChild(option);
}





filterBtn.addEventListener("click", () =>{
    filter.classList.toggle("d-none");
    // showCase.classList.add("d-none");
    // cancelBtn.classList.remove("d-none");

})

// cancelBtn.addEventListener("click", () => {
//     filter.classList.add("d-none");
// })




function send() {
    const fd = new FormData(form);
    options = {
        method:"POST",
        body:fd
    }
    getRequest(filterProfilesUrl, options);
}


form.addEventListener("submit", (event) => {
    event.preventDefault();
    // filter.classList.add("d-none");
    send();
})





















