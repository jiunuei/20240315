//登入頁面
<template>
  <div>
    <input type="text" v-model="phoneNumber" placeholder="請輸入手機號碼" />
    <button @click="login">登入</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      phoneNumber: ''
    };
  },
  methods: {
    async login() {
      try {
        // 使用 fetch 或其他 HTTP 客戶端庫進行 RESTful API 請求
        const response = await fetch('/api/login', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            phoneNumber: this.phoneNumber
          })
        });

        // 檢查響應狀態
        if (response.ok) {
          // 登入成功，可以在此處執行相應的操作，例如導航到下一個頁面
          console.log('登入成功');
        } else {
          // 登入失敗，處理錯誤訊息
          console.error('登入失敗');
        }
      } catch (error) {
        // 處理請求錯誤
        console.error('發生錯誤：', error);
      }
    }
  }
};
</script>



//借閱書籍頁面
<template>
  <div>
    <h2>借閱書籍</h2>
    <input type="text" v-model="bookTitle" placeholder="請輸入書籍標題" />
    <button @click="borrowBook">借閱</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      bookTitle: ''
    };
  },
  methods: {
    borrowBook() {
      // 使用 RESTful API 進行書籍借閱
    }
  }
};
</script>


