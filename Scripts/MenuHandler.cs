using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MenuHandler : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Debug.Log("Game started!");
    }

    //When environment Configuration button is pressed.
    public void OnEnvironmentConfig()
    {
        Debug.Log("You clicked Environment Configuration Button");
    }

    //When Simulation Setup button is pressed.
    public void OnSimulationSetup()
    {
        Debug.Log("You clicked Simulation Setup Button");
    }


    //When Back button is clicked.
    public void OnBackPressed()
    {
        Debug.Log("Back button clicked!");
    }

    //When Exit button is clicked.
    public void OnExit()
    {
        Debug.Log("Exit button clicked!");
        UnityEditor.EditorApplication.isPlaying = false;
        Application.Quit();
    }

    //When Manual Setup button is clicked.
    public void OnManualSetup()
    {
        Debug.Log("Configuring Manual Setup!");
    }

    //When Automatic Setup button is clicked.
    public void OnAutoSetup()
    {
        Debug.Log("Configuring Automatic Setup!");
    }

    //When Submit button is clicked.
    public void OnSubmit()
    {
        Debug.Log("Submit button clicked!");
        SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex+1);

    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
