#!usr/local/bin/perl

use strict;
use warnings;

#the game is case sensative.

my @samword=("computer","radio","calculator","teacher","bureau","police","geometry","president","subject","country","en
viroment","classroom","animals","province","month","politics","puzzle","instrument","kitchen","language",
"vampire","ghost","solution","service","software","virus25","security","phonenumber","expert","website","ag
reement","support","compatibility","advanced","search","triathlon","immediately","encyclopedia","endur
ance","distance","nature","history","organization","international","championship","government","popula
rity","thousand","feature","wetsuit","fitness","legendary","variation","equal","approximatel","segment",
"priority","physics","branche","science","mathematics","lightning","dispersion","accelerator","detector","
terminology","design","operation","foundation","application","prediction","reference","measurement",
"concept","perspective","overview","position","airplane","symmetry","dimension","toxic","algebra","illust
ration","classic","verification","citation","unusual","resource","analysis","license","comedy","screenpl
ay","production","release","emphasis","director","trademark","vehicle","aircraft","experiment");

  my $state="y";
  my $istrue=1;
  my $word=@_;
  my $size=@samword;
 
  while($istrue)
    {
        
        if(!($state eq "y" || $state eq "n"))
    {
        print "\nEnter a valid input: ";
        $state=<STDIN>;
        chomp $state;

    }
    
     if($state eq "n")
     {
         $istrue=0;
     }
     if($state eq "y")
      {play();}
        
     }
sub play {
      $word = $samword[int (rand($size-1))];
       game_start();
       print "\ndo you want to play again y/n: ";
   $state=<STDIN>;
    chomp $state;
    }

sub body 
{
    (my $cnt)=@_;
    if ($cnt==0)
   { print "This is the setup, guess the correct letters:\n";
    print "_______\n|    |\n|\n|\n|\n_______\n";
   }
   elsif($cnt==1)
   {
       print "_______\n|    |\n|    O\n|\n|\n_______\n";
   }
    elsif($cnt==2)
   {
       print "_______\n|    |\n|    O\n|    |\n|    |\n|\n_______\n";
   }
    elsif($cnt==3)
   {
       print "_______\n|    |\n|    O\n|   \\|\n|    |\n|\n_______\n";
   }
    elsif($cnt==4)
   {
       print "_______\n|    |\n|    O\n|   \\|\/\n|    |\n|\n_______\n";
   }
    elsif($cnt==5)
   {
       print "_______\n|    |\n|    O\n|   \\|\/\n|    |\n|   \/|\n_______\n";
   }
    elsif($cnt==6)
   {
       print "_______\n|    |\n|    O\n|   \\|\/\n|    |\n|   \/|\\\n_______\n";
   }
}        


sub game_start
{   
    my @already_guessed;
    my $limit=6;
    my $done=0;
    my $n=length($word);
    my @being_created=("-","-","-","-","-","-","-","-","-","-","-","-","-","-","-");
    my $isduplicate=0;
    while($limit>=0)
    {
         if( $done == $n)
    {
        print "Congratulation you won the game!";
    }
   last if( $done == $n);


        body(6-$limit);
        last if ($limit==0);
        print "your word is: ";
        for(my $i=0;$i<$n;$i++)
    {
        print "$being_created[$i]";
    }
   
    print "\nGuesses so far: @already_guessed";
    my $guessed_length=@already_guessed;


    print "\nMake a guess: ";
    my $guess=<STDIN>;
    chomp $guess;
   
   for(my $same=0;$same<$guessed_length;$same++)
{
    if($guess eq $already_guessed[$same])
    {$isduplicate++;

    }
    
}

    while($isduplicate>0)
{
     print "\n You already guessed it earlier, try guessing again: ";
    print "\nMake a guess: ";
    my $guess=<STDIN>;
    chomp $guess; 
    $isduplicate=0;
    
    for(my $same=0;$same<$guessed_length;$same++)
{
    if($guess eq $already_guessed[$same])
    {
        $isduplicate++;
    }

}

}
    push @already_guessed, "$guess";

    my $issame=0;
    my $m=0;
    foreach my $char(split //, $word)
    {
    
        if($guess eq $char)
        {
            $issame++;
            $being_created[$m]=$guess;
          $done++;
        }
    $m++;
    }
    if($issame!=0)
    {
        print "\nGood guess!";
    }
    else 
    {
        $limit--;
        print "\nBad guess";
    }
    print "\nYou have $limit body parts left\n";
    

    }
    print "\nYour word was: $word\nThank you!"
    
}
