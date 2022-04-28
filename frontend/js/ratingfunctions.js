const rateDiv = document.getElementById("rate");
const openRate = document.getElementById("openRate");
const otherId = localStorage.getItem("userId")

//recap from what i have today. I still need to be able to move on to the message tabs a link to go back to the home screen. a logout?

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
    let url = "http://localhost:8080/api/rating"
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
async function getAllRating(){
    const url = "http://localhost:8080/api/rating"
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
    const url = "http://localhost:8080/api/rating/average"
    const response = await fetch(url + "/" + otherId)
    if (response.status == 200){
        const body = await response.json();
        const averageRate = document.getElementById("averageRate")
        averageRate.textContent= `Average Rating: ${body}`
        // This is where you would change the value of wherever the average rating belongs
    }
}


async function buyerOrSeller(){
    // may need another dao to make this work
    const isBuyer = localStorage.getItem("isBuyer")
    const isSeller = localStorage.getItem("isSeller")
    console.log(isBuyer);
    console.log(isSeller);
    // const url = "http://localhost:8080/api/user/"
    // console.log("function working");
    // const response = await fetch(url + otherId);
    // if(response == 200){
    //     const body = response.json();
    //     console.log(body);
    if(isSeller == "true"){
        console.log("seller");
        sellerInfo()
    }
    if(isBuyer == "true"){
        console.log("buyer");
        buyerInfo()
    }
        // else{
        //     window.location.href="home.html"
        // }
    // }
}
function sellerInfo(){
    //four steps: we need to do average rating,product, transaction, ratings
    //step one
    getAverageRating();
    //step two
    listProductsBySeller()
    //step four
    getAllRating()

}
//api link is weird
async function listProductsBySeller(){
    console.log("working?");
    const url = "http://localhost:8080/products/"
    const response = await fetch(url + otherId);
    
    console.log("working?");
    const productDiv= document.getElementById("products")
    let productId = []
    if(response.status == 200){
        const body = await response.json();
        for(let product of body){
            productId.push(product.productId);
            let divContainer = document.createElement("div")
            let title = document.createElement("h2")
            let description = document.createElement("p")
            let price = document.createElement("p")
            let inventory = document.createElement("p")
            let deleteBtn = document.createElement("button")
            deleteBtn.onclick="deleteProduct()"
            deleteBtn.value= product.productId
            deleteBtn.textContent= "Delete this product"
            title.textContent = product.title
            description.textContent = product.description
            price.textContent = `$${product.price}`
            inventory.textContent= `Inventory: ${product.inventory}`
            divContainer.appendChild(title)
            divContainer.appendChild(description)
            divContainer.appendChild(price)
            divContainer.appendChild(inventory)
            productDiv.appendChild(divContainer)
        }
        getTransactions(productId);
    }
}
//needs to be able to change status
async function getTransactions(productIds){
    let url = "http://localhost:8080/api/transactions/product/"
    const transactionsEl = document.getElementById("transactions")
    for(let id of productIds){
        let response = await fetch(url+id)
        if(response.status == 200){
            let body = await response.json()
            for(let tran of body){
                let divContainer = document.createElement("div")
                let transactionId = document.createElement("h1")
                let amount = document.createElement("p")
                let status = document.createElement("p")

                status.textContent= "Status:"
                let statusMain = document.createElement("select")

                let statusPending= document.createElement("option")
                statusPending.value = "pending"
                statusPending.textContent = "pending"

                let statusShipped= document.createElement("option")
                statusShipped.value = "shipped"
                statusShipped.textContent = "shipped"

                let statusDelivered= document.createElement("option")
                statusDelivered.value = "delivered"
                statusDelivered.textContent = "delivered"

                statusMain.appendChild(statusPending)
                statusMain.appendChild(statusShipped)
                statusMain.appendChild(statusDelivered)

                let buttonBtn = document.createElement("button")
                buttonBtn.onclick = "updateTransactionStatus()"
                buttonBtn.innerText= "Update Status"

                let productId = document.createElement("p")

                transactionId.textContent = `Transaction: ${tran.transactionId}`
                amount.textContent = `Amount: ${tran.amount}`
                status.textContent = `Status: ${tran.status}`
                productId.textContent = `Product Id: ${tran.productId}`

                divContainer.appendChild(transactionId)
                divContainer.appendChild(amount)
                divContainer.appendChild(status)
                divContainer.appendChild(statusMain)

                divContainer.appendChild(productId)
                transactionsEl.appendChild(divContainer)
            }
        }
    }
}
//this needs to be edited to grab the things from the previous area.
async function updateTransactionStatus(){
    const status = document.getElementById("status")
    const transactionId = document.getElementById("transactionId")
    const url = `"http://localhost:8080/api/transactions/${transactionId.value}/${status.value}`
    const response = await fetch(url)
    if(response.status == 200){
        alert("Successful status update")
    }
    else{
        alert("Unsuccessful status update")
    }
}

async function deleteProduct(){
    const id = this.value;
    let url = "http://localhost:8080/RemoveProduct/";
    let config = {
        method:"DELETE"
    }
    let response = await fetch(url+id,config)
    if(response.status == 200){
        alert("Product has sucessfully been deleted")
    }
    else{
        alert("Product delete has failed")
    }
}

async function buyerInfo(){
    const url = "http://localhost:8080/api/transactions/"
    const response = await fetch(url + otherId);
    const transactionsEl = document.getElementById("transactions")
    if(response.status == 200) {
        const body = await response.json();
        console.log(body);
        for(let transaction of body){
            let divContainer = document.createElement("div")
            let transactionId = document.createElement("h1")
            let amount = document.createElement("p")
            let status = document.createElement("p")
            let productId = document.createElement("p")
            transactionId.textContent = `Transaction: ${transaction.transactionId}`
            amount.textContent = `Amount: ${transaction.amount}`
            status.textContent = `Status: ${transaction.status}`
            productId.textContent = `Product Id: ${transaction.productId}`
            divContainer.appendChild(transactionId)
            divContainer.appendChild(amount)
            divContainer.appendChild(status)
            divContainer.appendChild(productId)
            transactionsEl.appendChild(divContainer)
        }
    }
}
