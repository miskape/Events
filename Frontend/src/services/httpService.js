import axios from "axios";
import { toast } from "react-toastify";

axios.interceptors.response.use(null, (error) => {
  console.log("Logging the error", error);
  toast.error("Something went wrong at our end.");
  return Promise.reject(error);
});

export default {
  get: axios.get,
};
