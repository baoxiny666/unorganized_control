const localStorageGet = name => {
    const storage = localStorage.getItem("wuzuzuser");
    const time = new Date().getTime();
    let result = {};
    if (storage) {
        const obj = JSON.parse(storage);
        if (time < obj.expire) {
            result = obj.data;
        } else {
            localStorage.removeItem("wuzuzuser");
            parent.window.location.href = basePath+"/";
        }
    }
    return result;
};
