struct play_args {
    int row; 
    int column;
    int player;
};

program TTT {
    version V1 {
        string CURRENTBOARD(void)=1;
        int PLAY(play_args)=2;
        int CHECKWINNER(void)=3;
    } = 1;
} = 0x65907;
