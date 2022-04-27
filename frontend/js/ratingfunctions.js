const rateDiv = document.getElementById("rate");
const openRate = document.getElementById("openRate");

//part 1
function makeRatingModal(){
    rateDiv.style.display = "block";
};

window.onclick = function(event) {
    if (event.target == rateDiv) {
      rateDiv.style.display = "none";
    }
  }
async function createRating(){
    const rating = document.getElementById("rating");
    const comment = document.getElementById("comment");
    const personalInformation = JSON.parse(localStorage.getItem("user"));
    const otherId = document.URL.split("/").pop();
    if(personalInformation.isBuyer=="true"){
        const body = {
            ratingId: 0,
            rate: rating.options[rating.selectedIndex].value,
            comment: comment.value,
            buyerId: personalInformation.ratingId,
            sellerId: otherId
        }
    } else {
        
        const body = {
            ratingId: 0,
            rate: rating.options[rating.selectedIndex].value,
            comment: comment.value,
            buyerId: otherId,
            sellerId: personalInformation.ratingId
        }
    }
    let config = {
        method:"POST",
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify(body)
    };
    let url = ""
    const response = await fetch(url,config)
    if(response.status== 200) {
        alert("Rating has sucessfully been made")
        rateDiv.style.display="none"
        getAllRating()
        getAverageRating()
    } 
    else{
        alert("Rating did not work please try again")
    }
}

//part 2
function getAllRating(){
    const otherId = document.URL.split("/").pop();
    const url = ""
    const response = await fetch(url + "/" + otherId)
    if(response.status == 200){
        const body = await response.json();
        for(let rate of body){
            const divContainer = document.createElement("div");
            const rateName = document.createElement("h5")
            rateName.textContent= `Rating: ${rate.rate}`
            const commentName = document.createElement("p")
            commentName.innerHTML = rate.comment
            divContainer.appendChild(rateName)
            divContainer.appendChild(commentName)
            // append this to the master div for rates and also need to add classes if i need them above

        }
    }
}

async function getAverageRating(){
    const otherId = document.URL.split("/").pop();
    const url = ""
    const response = await fetch(url + "/" + otherId)
    if (response.status == 200){
        const body = response.json();
        // This is where you would change the value of wherever the average rating belongs
    }
}
