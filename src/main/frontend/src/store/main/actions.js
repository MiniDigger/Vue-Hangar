import axios from "axios";

const versionsGist =
  "https://gist.githubusercontent.com/MiniDigger/6c483628f4745b1b326862acb89a82d2/raw";

export const loadVersions = ({ commit }) => {
  return new Promise((resolve, reject) => {
    axios
      .get(versionsGist)
      .then(response => {
        if (response && response.status === 200 && response.data) {
          Object.keys(response.data).forEach(key => response.data[key].id = key);
          commit("setVersions", { data: response.data });
          resolve(response.data);
        } else {
          reject("Error: " + response);
        }
      })
      .catch(error => {
        reject(error);
      });
  });
};
