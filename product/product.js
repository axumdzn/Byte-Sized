async function createProduct() {

    const productId = document.getElementById("productId")
    const price = document.getElementById("price")
    const user = JSON.parse(LocalStorage.getItem("userId"))
    const title = document.getElementById("title")
    const description = document.getElementById("description")
    const inventory = document.getElementById("inventory")



    const product = {
        productId: 1,
        title: title.value,
        description: description.value,
        price: price.value,
        inventory: inventory.value,
        sellerId: user

    }
    let config = {
        method: "POST",
        headers: { 'Content-Type': "application/json" },
        body: JSON.stringify(product)
    };
    let url = ""
    const response = await fetch("", config);
    if (response.status === 200) {
        alert("Added to the Cart");
    } else {
        alert("Item already added");
    }


}